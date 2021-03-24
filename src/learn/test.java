package learn;


public class test {
    public static void main(String[] args) {
        // 使用多态
        Parent chidParent = new Child();
        System.out.println("Parent:" + chidParent.getAge()); //40
        System.out.println("Parent:" + chidParent.age); //18 这个结果你能接受吗？哈哈

        // 直接使用原本类型
        Child child = new Child();
        System.out.println("Child:" + child.getAge()); //40
        System.out.println("Child:" + child.age); //40
    }
}


class Child extends Parent {
    public Integer age = 40;

    @Override
    public Integer getAge() {
        return age;
    }

    @Override
    public void setAge(Integer age) {
        this.age = age;
    }
}


class Parent {
    public Integer age = 18;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
