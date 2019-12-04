package bilgin_selimoglu_hw1;

public class StudentBase {

    Student[] array;

    public StudentBase(int numberOfStudents) {
        array = new Student[numberOfStudents];
    }

    public void addStudent(Student s, int index) {
        array[index] = s;
    }

    public static int[] bubbleSort(long[] data) {

        int[] indexArray = new int[data.length];

        for (int i = 0; i < data.length; i++) {
            indexArray[i] = i;
        }

        for (int i = data.length; i > 1; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (data[j] > data[j + 1]) {

                    /* SORT DATA */
                    long dummy = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = dummy;

                    /* SORT INDEX */
                    int temp = indexArray[j];
                    indexArray[j] = indexArray[j + 1];
                    indexArray[j + 1] = temp;
                }
            }
        }

        return indexArray;
    }

    public static int[] bubbleSort(int[] data) {

        int[] indexArray = new int[data.length];

        for (int i = 0; i < data.length; i++) {
            indexArray[i] = i;
        }

        for (int i = data.length; i > 1; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (data[j] > data[j + 1]) {

                    /* SORT DATA */
                    int dummy = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = dummy;

                    /* SORT INDEX */
                    int temp = indexArray[j];
                    indexArray[j] = indexArray[j + 1];
                    indexArray[j + 1] = temp;
                }
            }
        }

        return indexArray;
    }

    public void sort_ID() {

        System.out.println("\nSORTED BY ID");

        long[] ID_array = new long[array.length];

        for (int i = 0; i < array.length; i++) {
            ID_array[i] = array[i].ID;
        }

        int[] sorted_index = bubbleSort(ID_array);

        for (int i = 0; i < sorted_index.length; i++) {
            System.out.println(array[sorted_index[i]].toString());
        }

    }

    public void sort_Year() {

        System.out.println("\nSORTED BY YEAR");

        int[] year_array = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            year_array[i] = array[i].admYear;
        }

        int[] sorted_index = bubbleSort(year_array);

        for (int i = 0; i < sorted_index.length; i++) {
            System.out.println(array[sorted_index[i]].toString());
        }

    }

    public void sort_Age() {

        System.out.println("\nSORTED BY AGE");

        int[] age_array = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            age_array[i] = array[i].age;
        }

        int[] sorted_index = bubbleSort(age_array);

        for (int i = 0; i < sorted_index.length; i++) {
            System.out.println(array[sorted_index[i]].toString());
        }
    }
}
