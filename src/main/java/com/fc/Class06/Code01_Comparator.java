package Class06;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Auther: FC.Clb
 * @Date: 2025/1/22 - 01 - 22 - 11:15
 * @Description: Class06
 * @version: 1.0
 */
public class Code01_Comparator {
    /*任何比较器：
    * compare方法里遵循一个统一的规范：
    * 返回负数时，第一个参数排前面
    * 返回正数时，第二个参数排后面
    * 返回0则无所谓谁排前面
    */
    public static class Student{
        public String name;
        public int id;
        public int age;

        public Student(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }

    public static class idShengAgeJiang implements Comparator<Student> {
        //idShengAgeJiang2的简化版，二者效果一样
        @Override
        public int compare(Student s1, Student s2) {
            return s1.id == s2.id ? (s2.age - s1.age) : (s1.id - s2.id);
        }
    }
    public static class idShengAgeJiang2 implements Comparator<Student> {

        @Override
        public int compare(Student s1, Student s2) {
            if (s1.id != s2.id) {
                if (s1.id > s2.id) {
                    return 1;
                } else if (s1.id < s2.id) {
                    return -1;
                } else {
                    return 0;
                }
            } else {
                if (s1.age > s2.age) {
                    return -1;
                } else if (s1.age < s2.age) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student("A", 1004, 18);
        Student s2 = new Student("B", 1004, 17);
        Student s3 = new Student("C", 1003, 10);
        Student s4 = new Student("D", 1003, 29);
        Student s5 = new Student("E", 1003, 30);

        Student[] students = new Student[]{s1, s2, s3, s4, s5};
        Arrays.sort(students, new idShengAgeJiang2());
        for (Student s : students) {
            System.out.println(s.name + " , " + s.id + " , " + s.age);
        }
    }

}
