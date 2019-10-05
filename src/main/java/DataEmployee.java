public enum DataEmployee {
    NAME(1),SURNAME(2),GENDER(3),SECTION(4),SALARY(5),AGE(6),NUMBER_CHILD(7),MARITAL_STATUS(8);


    private final int id;


    DataEmployee(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
