package SetInt;

import java.util.ArrayList;
import java.util.Scanner;

public class SetInt {

    private static Scanner scan = new Scanner(System.in);
    private ArrayList<Integer> array = new ArrayList<>();

    public SetInt(int[] elements)  {
        for (int i = 0; i < elements.length; i++) {
            array.add(elements[i]);
        }
    }

    public SetInt union(SetInt b) {
        int[] union = new int[array.size() + b.array.size()];
        for (int i = 0; i < array.size(); i++) {
            union[i] = array.get(i);
        }
        int bIndex = 0;
        for (int i = array.size(); i < union.length; i++) {
            union[i] = b.array.get(bIndex);
            bIndex++;
        }
        return new SetInt(union);
    }


    private boolean includes(int x, ArrayList<Integer> array) {
        for (int i = 0; i < array.size(); i++) {
            if (x == array.get(i)) {
                return true;
            }
        }
        return false;
    }

    private int[] toArray(ArrayList<Integer> arrayList) {
        int[] array = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            array[i] = arrayList.get(i);
        }
        return array;
    }

    public SetInt intersection(SetInt b) {
        ArrayList<Integer> intersection = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            if (includes(array.get(i), b.array)) {
                intersection.add(array.get(i));
            }
        }
        return new SetInt(toArray(intersection));
    }

    public SetInt difference(SetInt b) {
        ArrayList<Integer> difference = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            if (!includes(array.get(i), b.array)) {
                difference.add(array.get(i));
            }
        }
        return new SetInt(toArray(difference));
    }

    public SetInt symmetricDifference(SetInt b) {
        ArrayList<Integer> symmetricDifference = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            if (!includes(array.get(i), b.array)) {
                symmetricDifference.add(array.get(i));
            }
        }
        for (int i = 0; i < b.array.size(); i++) {
            if (!includes(b.array.get(i), array)) {
                symmetricDifference.add(b.array.get(i));
            }
        }
        return new SetInt(toArray(symmetricDifference));
    }

    public String toString() {
        String a = "{";
        for (int i = 0; i < array.size(); i++) {
            a += array.get(i);
            if (array.size() - 1 != i) {
                a += ", ";
            } else {
                a += "}";
            }
        }

        return a;
    }


    public static void main(String[] args) {
        SetInt a = new SetInt(new int[]{1, 2, 3, 4});
        SetInt b = new SetInt(new int[]{3, 4, 5, 6});

        SetInt union = a.union(b);
        System.out.println(union); // {1, 2, 3, 4, 5, 6}

        SetInt intersection = a.intersection(b);
        System.out.println(intersection); // {3, 4}

        SetInt difference = a.difference(b);
        System.out.println(difference); // {1, 2}

        SetInt symmetricDifference = a.symmetricDifference(b);
        System.out.println(symmetricDifference); // {1, 2, 5, 6}

    }

}
