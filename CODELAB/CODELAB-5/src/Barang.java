public class Barang {
    private String nama;
    private int Stok;

    public Barang(String nama, int Stok){
        this.nama = nama;
        this.Stok = Stok;
    }

    public String getNama(){
        return nama;
    }

    public int getStok(){
        return Stok;
    }

    public void setStok(int Stok){
        this.Stok = Stok;
    }

    public void kurangiStok(int jumlah) throws StokTIdakCukupException{
        if(jumlah > Stok){
            throw new StokTIdakCukupException();
        }
        Stok -= jumlah;
    }
}
