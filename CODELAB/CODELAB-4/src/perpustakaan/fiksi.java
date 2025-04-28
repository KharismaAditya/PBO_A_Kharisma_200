package perpustakaan;

public class fiksi extends buku{
    private String genre;
    public fiksi(String judul, String penulis, String genre) {
        super(judul, penulis);
        this.genre = genre;
    }

    @Override
    public void displayInfo() {
        System.out.println("Buku Fiksi: " + judul + " oleh " + penulis + "(Genre: " + genre + ")");
    }
}
