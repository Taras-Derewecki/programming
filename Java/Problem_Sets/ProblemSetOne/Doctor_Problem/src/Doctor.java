public class Doctor extends SalariedEmployee{
    private String doctorType; //"Pediatrician", "Obstetrician", "General practitioner"
    private double fee = 0.0;

    public Doctor(){}

    public Doctor(String doctorType, double fee){
        this.doctorType = doctorType;
        this.fee = fee;
    }

    public Doctor(String doctorType){
        this.doctorType = doctorType;
    }

    public String getDoctorType(){ return doctorType; }
    public double getFee(){ return fee; }

    public void setDoctorType(String doctorType){ this.doctorType = doctorType; }
    public void setFee(double fee) { this.fee = fee; }

    @Override
    public String toString() {
        return "Doctor{" +
                "type='" + doctorType + '\'' +
                ", fee='" + fee + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
