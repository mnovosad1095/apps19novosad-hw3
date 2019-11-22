package ua.edu.ucu;

import java.util.Arrays;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.BaseArray;
import ua.edu.ucu.smartarr.DistinctDecorator;
import ua.edu.ucu.smartarr.FilterDecorator;
import ua.edu.ucu.smartarr.MapDecorator;
import ua.edu.ucu.smartarr.SmartArray;
import ua.edu.ucu.smartarr.SortDecorator;

public class SmartArrayApp {

    public static void main(String[] args) {
            BaseArray a = new BaseArray(new Integer[]{1,2,3,2,4,5});
            MyFunction mf = new MyFunction(){
            
                @Override
                public String operationDescription() {
                    return " Squared";
                }
            
                @Override
                public Object apply(Object t) {
                    return (Integer)t*(Integer)t;
                }
            };
            MapDecorator b = new MapDecorator(a, mf);
            System.out.println(Arrays.toString(a.toArray()));
            System.out.println(Arrays.toString(b.toArray()));
    
            a.setValue(0); // що це працювало додайте метод setValue(int index){array[index] = 0};
            System.out.println(Arrays.toString(a.toArray()));
            System.out.println(Arrays.toString(b.toArray()));
    
    }

    public static Integer[]
            filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {
                
        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }

            @Override
            public String operationDescription() {
                return " if elements are positive";
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object a, Object b) {
                return ((Integer) a) - ((Integer) b);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }

            @Override
            public String operationDescription() {
                return "Elements multiplied on 2";
            }
        };

        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, pr); // Result: [2, 1, 3];
        sa = new SortDecorator(sa, cmp); // Result: [1, 2, 3]
        sa = new MapDecorator(sa, func); // Result: [2, 4, 6]

        // Alternative
//        sa = new MapDecorator(
//                    new SortDecorator(
//                        new FilterDecorator(sa, pr),
//                    cmp),
//                func);
        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
            findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(Student[] students) {

        // Hint: to convert Object[] to String[] - use the following code
        //Object[] result = studentSmartArray.toArray();
        //return Arrays.copyOf(result, result.length, String[].class);
        MyPredicate pred = new MyPredicate() {
            final int GPA = 4;
            final int YEAR = 2;
        
            @Override
            public boolean test(Object t) {
                Student st = (Student) t;
                return st.getYear() == YEAR && st.getGPA() >= GPA;
            }
        
            @Override
            public String operationDescription() {
                return " only second year students with GPA greater than 4";
            }
        };

        MyComparator comparator = new MyComparator() {
        
            @Override
            public int compare(Object a, Object b) {
                return ((Student) a).getSurname().compareTo(((Student)b).getSurname());
            }
        };

        MyFunction function = new MyFunction() {
        
            @Override 
            public String operationDescription() {
                return " Convert to String";
            }
        
            @Override 
            public Object apply(Object t) {
                return ((Student) t).getSurname() + " " + ((Student)t).getName();
            }
        };

        SmartArray sa = new BaseArray(students);
        
        sa = new FilterDecorator(sa, pred);
        sa = new SortDecorator(sa, comparator);
        sa = new MapDecorator(sa, function);
        sa = new DistinctDecorator(sa);

        return Arrays.copyOf(sa.toArray(), sa.size(), String[].class);
    }
}
