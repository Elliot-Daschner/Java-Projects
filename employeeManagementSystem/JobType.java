package employeeManagementSystem;

import java.util.Arrays;
public enum JobType
{
    FULL_TIME("Full Time"), PART_TIME("Part Time"), INTERN("Intern");

    private final String display;

    JobType(String display)
    {
        this.display = display;
    }

    @Override
    public String toString()
    {
        return display;
    }
    public static String[] toStringArray()
    {
        return Arrays.stream(JobType.values()).map(Enum::toString).toArray(String[]::new);
    }
}