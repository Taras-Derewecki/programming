public class DoctorTest {
    public static void main(String[] args) {
        Doctor dr = new Doctor();

        dr.setDoctorType("General practitioner"); dr.setFee(10);
        System.out.println(dr.getDoctorType() + " Fee: $" + dr.getFee());
        String x = dr.toString();

        dr.setDoctorType("Pediatrician"); dr.setFee(20);
        System.out.println(dr.getDoctorType() + " Fee: $" + dr.getFee());
        String y = dr.toString();

        dr.setDoctorType("Obstetrician"); dr.setFee(25);
        System.out.println(dr.getDoctorType() + " Fee: $" + dr.getFee());
        String z = dr.toString();

        if((x.equals(y) || x.equals(z) || y.equals(z))) System.out.println("These doctors are the same!");
        else System.out.println("These doctors aren't the same!");

        Doctor dr2 = new Doctor("General practicioner", 10);
        Doctor dr3 = new Doctor("General practicioner");
        dr3.setFee(10);

        System.out.println();
        System.out.println(dr2.getDoctorType() + " Fee: $" + dr2.getFee());
        System.out.println(dr3.getDoctorType() + " Fee: $" + dr3.getFee());

        if(dr2.toString().equals(dr3.toString()))
            System.out.println("These doctors are the same!");
        else System.out.println("These doctors aren't the same!");
    }
}
