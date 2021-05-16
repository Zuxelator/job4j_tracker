package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает работу банковского сервиса
 * Сервис представляет собой коллекцию map, где ключем является объект User,
 * а значением список его счетов
 * @author ILYA STAFEEV
 * @version 1.0
 */

public class BankService {
    /**
     * Хранение осуществляется в коллекции типа Map
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход нового пользователя банка и добавляет его в коллекцию,
     * если его там еще нет.
     * @param user Объект, который добавляется в коллекцию.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод принимает на вход пасспорт пользователя банка и добавляемый счет.
     * Если пользователь найден по пасспортным данным и если добавляемого счета еще нет
     * в списке счетов, то метод добавляет новый счет в этот список.
     * @param passport пасспорт, по которому производится поиск пользтователя
     * @param account добавляемый счет
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> userAccounts = users.get(user.get());
            if (!userAccounts.contains(account)) {
                userAccounts.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по пасспорту и возвращает его.
     * @param passport пасспорт по которому производится поиск
     * @return возвращает ссылку на объект Optional искомого пользователя
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(x -> x.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * В методе производится поиск счета по пасспорту и по реквизитам счета
     * @param passport пасспорт пользователя необходимый для поиска счета
     * @param requisite реквизиты счтеа, также необходимые для поиска
     * @return возвращает Optinonal искомого счета
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            if (!users.get(user.get()).isEmpty()) {
                return users.get(user.get())
                        .stream()
                        .filter(x -> x.getRequisite().equals(requisite))
                        .findFirst();
            }
        }
        return Optional.empty();
    }

    /**
     * Метод переводит с одного счета на другой указанную сумму денег.
     * Метод принимает пасспортные данные отправителя и получателя,
     * реквизиты счетеов отправителя и получателя, а также сумму, которую необходимо перевести.
     * В случае успеха метод вернёт true
     * @param srcPassport пасспорт отправителя
     * @param srcRequisite реквизиты счета отправителя
     * @param destPassport паспорт получаетеля
     * @param destRequisite реквизиты счета получателя
     * @param amount сумма к переводу
     * @return вернет true в случае, если оба счета присутствуют в коллекции
     * и сумма к переводу не превышает баланс счета отправителя
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite).isPresent()
                ? findByRequisite(srcPassport, srcRequisite).get() : null;
        Account destAccount = findByRequisite(destPassport, destRequisite).isPresent()
                ? findByRequisite(destPassport, destRequisite).get() : null;
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}