package perpustakaan;

public class anggota implements peminjaman{
    private String nama;
    private String idAnggota;

    public anggota(String nama, String idAnggota){
        this.nama = nama;
        this.idAnggota = idAnggota;
    }
    public void tampilAnggota(){
        System.out.println("Anggota: " + nama + " (ID: " + idAnggota + ")");
    }

    @Override
    public void pinjamBuku(buku bukuAnch){
        System.out.println(nama + " meminjam buku berjudul: " + "'" + bukuAnch.getJudul() + "'" ) ;
    }
    public void pinjamBuku(buku bukuAnch, int durasi){
        System.out.println(nama + " meminjam buku berjudul: " + "'" +bukuAnch.getJudul() + "'" + " selama " + durasi + " hari");
    }

    @Override
    public void kembalikanBuku(buku bukuAnch) {
        System.out.println(nama + " mengembalikan buku berjudul: " + "'" + bukuAnch.getJudul() + "'") ;
    }
}
