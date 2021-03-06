package com.iqbal.salman.aplikasibpr;

import com.iqbal.salman.aplikasibpr.master.Agama;
import com.iqbal.salman.aplikasibpr.master.Nasabah;
import com.iqbal.salman.aplikasibpr.master.NasabahBadanUsaha;
import com.iqbal.salman.aplikasibpr.master.NasabahPerorangan;
import com.iqbal.salman.aplikasibpr.master.Pendidikan;
import com.iqbal.salman.aplikasibpr.master.RoleSecurity;
import com.iqbal.salman.aplikasibpr.master.UserSecurity;
import com.iqbal.salman.aplikasibpr.service.AgamaService;
import com.iqbal.salman.aplikasibpr.service.NasabahService;
import com.iqbal.salman.aplikasibpr.service.PendidikanService;
import com.iqbal.salman.aplikasibpr.service.UserService;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AplikasiBprApplicationTests extends TestCase {

    @Autowired
    private AgamaService agamaService;

    @Autowired
    private PendidikanService pendidikanService;
    @Autowired
    private UserService userService;
    @Autowired
    private NasabahService nasabahService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testSimpanAgama() {
        Agama islam = new Agama(null, "Islam", "Muslim", Timestamp.valueOf(LocalDateTime.now()), "admin");
        agamaService.save(islam);

        Agama kristen = new Agama(null, "Kristen", "Kristen Protestan", Timestamp.valueOf(LocalDateTime.now()), "admin");
        agamaService.save(kristen);

        List<Agama> daftarAgama = agamaService.findAll();
        assertEquals(daftarAgama.size(), 2);

        islam = agamaService.findByNama("Islam");
        assertNotNull(islam);

        List<Agama> daftarAgamaByNamaOrDesk
                = agamaService.mencariBerdasarkanNamaAtauDeskripsi("Islam");
        assertEquals(daftarAgamaByNamaOrDesk.size(), 1);

//        agamaService.delete(daftarAgama);
//        daftarAgama = agamaService.findAll();
//        assertEquals(daftarAgama.size(), 0);
//
        Agama islam2 = new Agama();
        islam2.setId(islam.getId());
        islam2.setNama("ISIS");
        islam2.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
        agamaService.save(islam2);
        islam2 = agamaService.findById(islam.getId());

        agamaService.updateById(kristen.getId(), "Budha", "Chinese");
        kristen = agamaService.findById(kristen.getId());
        assertEquals(kristen.getNama(), "Budha");
        assertEquals(kristen.getDeskripsi(), "Chinese");
        assertEquals(islam2.getNama(), "ISIS");

    }

    @Test
    public void testPendidikan() {
        List<Pendidikan> daftarPendidikan = pendidikanService.findAll();
        assertEquals(daftarPendidikan.size(), 3);
    }

    @Test
    public void testUser() {
        List<RoleSecurity> roles = this.userService.listRole();
        assertEquals(2, roles.size());

        List<RoleSecurity> users = this.userService.findUser();
        assertEquals(2, users.size());

        UserSecurity admin = this.userService.findByUsername("admin");
        assertNotNull(admin);
        assertEquals(2, admin.getListRole().size());

        UserSecurity dimas = this.userService.findByUsername("dimas");
        assertNotNull(dimas);
        assertEquals(1, dimas.getListRole().size());

    }

    @Test
    public void tesSimpanNasabah() {
        NasabahPerorangan dimas = new NasabahPerorangan();
        dimas.setNamaLengkap("Dimas Maryanto");
        dimas.setJenisKelamin("L");
        dimas.setNomerIdentitas("6212423408234");
        dimas.setAlamat("Jl. Bukit indah no B8");
        dimas = this.nasabahService.save(dimas);
        assertNotNull(dimas.getId());

        dimas = this.nasabahService.findPeroranganById(dimas.getId());
        assertNotNull(dimas);
        Nasabah bukan = this.nasabahService.findBadanUsahaById(dimas.getId());
        assertNull(bukan);

        NasabahBadanUsaha tabeldata = new NasabahBadanUsaha();
        tabeldata.setNamaLengkap("Tabel Data Informatika");
        tabeldata.setNomorNpwp("1242421423");
        tabeldata.setAlamat("Jl. margawangi raya no 8");
        tabeldata = this.nasabahService.save(tabeldata);
        assertNotNull(tabeldata.getId());

    }

}
