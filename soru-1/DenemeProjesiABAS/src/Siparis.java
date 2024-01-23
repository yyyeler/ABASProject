public class Siparis {
    private int siparisNo;
    private int malNo;
    private int miktar;
    private double birimFiyat;

    public Siparis(int siparisNo,int malNo,int miktar,double birimFiyat)
    {
        setSiparisNo(siparisNo);
        setMalNo(malNo);
        setMiktar(miktar);
        setBirimFiyat(birimFiyat);
    }

    public int getSiparisNo() {
        return siparisNo;
    }

    public void setSiparisNo(int siparisNo) {
        this.siparisNo = siparisNo;
    }

    public int getMalNo() {
        return malNo;
    }

    public void setMalNo(int malNo) {
        this.malNo = malNo;
    }

    public int getMiktar() {
        return miktar;
    }

    public void setMiktar(int miktar) {
        this.miktar = miktar;
    }

    public double getBirimFiyat() {
        return birimFiyat;
    }

    public void setBirimFiyat(double birimFiyat) {
        this.birimFiyat = birimFiyat;
    }

}
