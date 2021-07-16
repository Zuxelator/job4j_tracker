package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {

    private Connection cn;

    public SqlTracker() {
        init();
    }

    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement statement = cn.prepareStatement("INSERT INTO items (name, created) values (?, ?)",
                Statement.RETURN_GENERATED_KEYS)) {
            Timestamp timestampFromLDT = Timestamp.valueOf(item.getCreated());
            statement.setString(1, item.getName());
            statement.setTimestamp(2, timestampFromLDT);
            statement.execute();
            try (ResultSet rs = statement.getGeneratedKeys()) {
                rs.next();
                item.setId(rs.getInt(1));
            }
            return item;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean replace(int id, Item item) {
        try (PreparedStatement statement = cn.prepareStatement("UPDATE items SET name = ?, created = ? WHERE id = ?")) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            statement.setInt(3, id);
            return statement.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try (PreparedStatement statement = cn.prepareStatement("DELETE from items where id = ?")) {
            statement.setInt(1, id);
            return statement.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Item> findAll() {
        List<Item> list = new ArrayList<>();
        try (PreparedStatement statement = cn.prepareStatement("SELECT * from items;")) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                list.add(new Item(rs.getInt(1), rs.getString(2), rs.getTimestamp(3).toLocalDateTime()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> list = new ArrayList<>();
        try (PreparedStatement statement = cn.prepareStatement("SELECT * from items WHERE name = ?;")) {
            statement.setString(1, key);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                list.add(new Item(rs.getInt(1), rs.getString(2), rs.getTimestamp(3).toLocalDateTime()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Item findById(int id) {
        Item item = null;
        try (PreparedStatement statement = cn.prepareStatement("SELECT * from items WHERE id = ?;")) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            rs.next();
            item = new Item(rs.getInt(1), rs.getString(2), rs.getTimestamp(3).toLocalDateTime());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }
}