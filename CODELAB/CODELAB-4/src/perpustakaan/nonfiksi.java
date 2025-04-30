package perpustakaan;

public class nonfiksi extends buku{
    private String bidang;

    public nonfiksi(String judul, String penulis, String bidang) {
        super(judul, penulis);
        this.bidang = bidang;
    }

    @Override
    public void displayInfo(){
        System.out.println("Buku Non-Fiksi: " + judul + " oleh " + penulis + " ( Bidang: " + bidang + ")");
    }
}
