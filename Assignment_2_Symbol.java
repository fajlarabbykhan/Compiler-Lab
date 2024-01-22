class Symbol {
    private int sl;
    private String name;
    private String type;
    private String value;

    public Symbol(int sl, String name, String type, String value) {
        this.sl = sl;
        this.name = name;
        this.type = type;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return sl + "\t" + name + "\t"+ "\t"+ type + "\t"+ "\t"+ value;
    }
}