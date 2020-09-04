public class TestData {

    private long id;

    private String name;


    /**
     * Gets the value of id.
     *
     * @return the value of id
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the value of id.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets the value of name.
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of name.
     */
    public void setName(String name) {
        this.name = name;
    }

    public TestData(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
