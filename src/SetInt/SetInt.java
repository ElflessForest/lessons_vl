package SetInt;

public class SetInt {

    public SetInt(int[] elements)  {

    }

    public SetInt union(SetInt b) {
        return null;
    }

    public SetInt intersection(SetInt b) {
        return null;
    }

    public SetInt difference(SetInt b) {
        return null;
    }

    public SetInt symmetricDifference(SetInt b) {
        return null;
    }

    public String toString() {
        return "";
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
