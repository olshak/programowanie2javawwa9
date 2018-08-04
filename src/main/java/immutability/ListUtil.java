package immutability;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ListUtil {

  public static int sum(List<Integer> integerList) {
    return integerList.stream().mapToInt(x->x).sum();
//  rownoważne
//    int sum = 0;
//    for (Integer element : integerList) {
//      sum += element;
//    }
//    return sum;

  }

  public static List<Integer> changeValuesToAbsolutes(List<Integer> intList) {
    return intList.stream().map(Math::abs).collect(Collectors.toList());
//
//    for (int i = 0; i < intList.size(); i++) {
//      intList.set(i, Math.abs(intList.get(i)));
//    }
  }

  public static int sumAbsoluteValues(List<Integer> integerList) {
    return sum(changeValuesToAbsolutes(integerList));
  }


  public static void main(String[] args) {
    List<Integer> integerList = new ArrayList<>();
    integerList.add(1);
    integerList.add(-1);
    integerList.add(1);

    System.out.println("Suma wartosci bezwzglednych: " + sumAbsoluteValues(Collections.unmodifiableList(integerList)));
    System.out.println("Suma: " + sum(integerList));
  }
}
