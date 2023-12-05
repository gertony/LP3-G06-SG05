public class App{
    public static void main(String[] args) throws Exception{
        Integer[] intArray = {1,2,3,4,5};
        Double[] doubleArray = {1.2,1.2,3.3,4.4,5.5};
        Character[] charArray = {'h','o','l','a'};
        String stringArray = {"holi", "hapens","godri"};
        System.out.printf("Array integerArray contiene:%n");
        imprimirArray(intArray);
        System.out.printf("Array doubleArray contiene:%n");
        imprimirArray(doubleArray);
        System.out.printf("Array charArray contiene:%n");
        imprimirArray(charArray);
        System.out.printf("Array stringArray contiene:%n");
        imprimirArray(stringArray);
    }
    //generica
    public static <T> void imprimirArray(T[] inputArray){
        for(T elemento : inputArray){
            System.out.printlf("%s", elemento);
        }
        System.out.println();
    }

}
