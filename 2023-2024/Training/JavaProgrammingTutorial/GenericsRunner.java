import java.util.ArrayList;
import java.util.List;

public class GenericsRunner {

    static <X> X doSomething(X value) {
        return value;
    }

    static <X extends List> void duplicate(X list) {
        list.add(list);
    }

    static double sumOfNumberList(List<? extends Number> numbers) {
        double sum = 0.0;
        
        for(Number number:numbers) {
            sum += number.doubleValue();  // Convert to double
        }
        
        return sum;
    }

    static void addAFewNumbers(List<? super Number> numbers) {
        numbers.add(1);
        numbers.add(1l);
        numbers.add(1.0);
        numbers.add(1.0f);
    }
        
        

    public static void main(String[] args) {
        
        MyCustomList<String> list = new MyCustomList<>();
        list.addElement("Element-1");
        list.addElement("Element-2");
        String text = list.get(0);
        System.out.println(list);
        System.out.println(text);

        
        MyCustomList<Integer> list2 = new MyCustomList<>();
        list2.addElement(Integer.valueOf(5));
        list2.addElement(Integer.valueOf(9));
        System.out.println(list2);
        Integer num = list2.get(1);
        System.out.println(num);

        System.out.println(sumOfNumberList(List.of(1, 2, 3, 4, 5)));
        System.out.println(sumOfNumberList(List.of(1.1, 2.1, 3.1, 4.1, 5.1)));
        System.out.println(sumOfNumberList(List.of(1l, 2l, 3l, 4l, 5l)));
    
        List<Number> numberList = new ArrayList<>();
        addAFewNumbers(numberList);
        System.out.println(numberList);

    }
}
    