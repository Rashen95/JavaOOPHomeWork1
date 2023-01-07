public class Errors {
    public void error_change(){
        System.out.println("[----------------------]");
        System.out.println(" Нет такого пункта меню ");
        System.out.println("[----------------------]");
    }

    public void error_input(){
        System.out.println("====================############=======================");
        System.out.println("                Вы ничего не ввели                     ");
        System.out.println("====================############=======================");
    }

    public void error_search(){
        System.out.println("====================############=======================");
        System.out.println("        По вашему запросу ничего не найдено            ");
        System.out.println("====================############=======================");
    }
}
