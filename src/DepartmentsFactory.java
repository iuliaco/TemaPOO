public class DepartmentsFactory {
    public Department createDepartament(String departament) {
        if(departament == null || departament.isEmpty())
            return null;
         else if("IT".equals(departament)) {
            return new IT();
        } else if("Management".equals(departament)) {
            return new Management();
        } else if("Marketing".equals(departament)) {
            return new Marketing();
        } else if("Finance".equals(departament)) {
            return new Finance();
        }
        return null;
    }
}
