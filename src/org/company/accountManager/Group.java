package org.company.accountManager;

public enum Group {

    STUDENT("Student"), TEACHER("Teacher"), ADMIN("Admin");

    private String name;

    Group(String name) {
        this.name = name;
    }

    public static Group toGroup(String name)
    {
        for (Group group : Group.values())
            if (group.name.equals(name))
                return group;
            return null;
    }
}
