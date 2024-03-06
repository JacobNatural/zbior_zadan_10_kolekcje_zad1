package zad1.client;

import java.math.BigDecimal;
import java.util.Objects;

public class Client {
    private final String name;
    private final String surname;
    private final int age;
    private final BigDecimal cash;

    public Client(String name, String surname, int age, BigDecimal cash) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.cash = cash;
    }

    public Client(String[] data){
        this.name = data[0];
        this.surname = data[1];
        this.age = Integer.parseInt(data[2]);
        this.cash = new BigDecimal(data[3]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (age != client.age) return false;
        if (!Objects.equals(name, client.name)) return false;
        if (!Objects.equals(surname, client.surname)) return false;
        return Objects.equals(cash, client.cash);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (cash != null ? cash.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", cash=" + cash +
                '}';
    }
}
