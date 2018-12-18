package com.sep.naucnacentrala.service;

import com.sep.naucnacentrala.constants.Constants;
import com.sep.naucnacentrala.dto.IzdanjeMagazinaDTO;
import com.sep.naucnacentrala.dto.MagazinDTO;
import com.sep.naucnacentrala.dto.NaucniRadDTO;
import com.sep.naucnacentrala.model.*;
import com.sep.naucnacentrala.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MagazinService {

    @Autowired
    private MagazinRepository magazinRepository;

    @Autowired
    private IzdanjeMagazinaRepository izdanjeMagazinaRepository;

    @Autowired
    private NaucniRadRepository naucniRadRepository;

    @Autowired
    private KorisnikRepository korisnikRepository;

    @Autowired
    private ClanarinaRepository clanarinaRepository;

    @Autowired
    private KupovinaRepository kupovinaRepository;

    public List<Magazin> findAllMagazin() {
        return magazinRepository.findAll();
    }

    public List<IzdanjeMagazina> findAllIzdanjeMagazina(Long magazinId) {
        return izdanjeMagazinaRepository.findByMagazinId(magazinId);
    }

    public List<NaucniRad> findAllNaucniRadByIzdanjeMagazina(Long izdanjeMagazina) {
        return naucniRadRepository.findByIzdanjeMagazinaId(izdanjeMagazina);
    }

    public List<NaucniRad> findAllNaucniRadByMagazin(Long magazinId) {
        return naucniRadRepository.findByMagazinId(magazinId);
    }

    public List<MagazinDTO> findAllListaMagazina(Long korisnikId) {
        Optional<Korisnik> korisnik = korisnikRepository.findById(korisnikId);

        List<MagazinDTO> sviMagazini = new ArrayList<>();

        List<Magazin> magazini = findAllMagazin();
        if (korisnik.isPresent()) {
            if (Constants.ULOGA_AUTOR.equals(korisnik.get().getUloga())) {
                for (Magazin m : magazini) {
                    MagazinDTO mDTO = new MagazinDTO(m);
                    if (m.getOpenAccess()) {
                        if (placenaClanarinaZaMagazin(korisnikId, m.getId())) {
                            mDTO.setPlatiClanarinu(false);
                            mDTO.setPostaviRad(true);
                        }
                        else {
                            mDTO.setPlatiClanarinu(true);
                            mDTO.setPostaviRad(false);
                        }
                        sviMagazini.add(mDTO);
                    }
                    else {
                        mDTO.setPlatiClanarinu(false);
                        mDTO.setPostaviRad(true);
                        sviMagazini.add(mDTO);
                    }
                }

            }
            else {          //kad je citalac
                for (Magazin m : magazini) {
                    MagazinDTO mDTO = new MagazinDTO(m);
                    if (!m.getOpenAccess()) {
                        if (placenaClanarinaZaMagazin(korisnikId, m.getId())) {
                            mDTO.setPlatiClanarinu(false);
                        }
                        else {
                            mDTO.setPlatiClanarinu(true);
                        }
                        sviMagazini.add(mDTO);
                    }
                    else {
                        mDTO.setPlatiClanarinu(false);
                        sviMagazini.add(mDTO);
                    }
                }
            }
        }

        return sviMagazini;

    }

    private boolean placenaClanarinaZaMagazin(Long korisnikId, Long magazinId) {
        String danasnjiDatum = "20181201";
        Clanarina clanarina = clanarinaRepository.findByKorisnikIdAndMagazinIdAndDatumPocetkaLessThanEqualAndDatumZavrsetkaGreaterThanEqual(korisnikId, magazinId, danasnjiDatum, danasnjiDatum);
        if (clanarina != null) {
            return true;
        }
        else {
            return false;
        }
    }

    public  List<IzdanjeMagazinaDTO> findAllListaIzdanjeMagazina(Long korisnikId, Long magazinId) {
        Optional<Korisnik> korisnik = korisnikRepository.findById(korisnikId);

        List<IzdanjeMagazinaDTO> svaIzdanjaMagazina = new ArrayList<>();
        List<IzdanjeMagazina> izdanja = izdanjeMagazinaRepository.findByMagazinId(magazinId);
        if (korisnik.isPresent()) {
            if (Constants.ULOGA_CITALAC.equals(korisnik.get().getUloga())) {
                for (IzdanjeMagazina izdanjeMagazina : izdanja) {
                    Magazin m = magazinRepository.findById(izdanjeMagazina.getMagazinId()).get();
                    IzdanjeMagazinaDTO izdanjeDTO = new IzdanjeMagazinaDTO(m, izdanjeMagazina);
                    if (!m.getOpenAccess()) {
                        if (placenaClanarinaZaMagazin(korisnikId, magazinId)) {
                            izdanjeDTO.setPreuzmiIzdanje(true);
                            izdanjeDTO.setKupiIzdanje(false);
                        }
                        else {
                            if (kupljeno(korisnikId, izdanjeMagazina.getId(), Constants.TIP_PROIZVODA_IZDANJE_MAGAZINA)) {
                                izdanjeDTO.setPreuzmiIzdanje(true);
                                izdanjeDTO.setKupiIzdanje(false);
                            } else {
                                izdanjeDTO.setPreuzmiIzdanje(false);
                                izdanjeDTO.setKupiIzdanje(true);
                            }
                        }
                    }
                    else {
                        izdanjeDTO.setPreuzmiIzdanje(true);
                        izdanjeDTO.setKupiIzdanje(false);
                    }
                    svaIzdanjaMagazina.add(izdanjeDTO);
                }
            }
        }

        return svaIzdanjaMagazina;

    }


    public  List<NaucniRadDTO> findAllListaNaucniRad(Long korisnikId, Long izdanjeMagazinaId) {
        Optional<Korisnik> korisnik = korisnikRepository.findById(korisnikId);

        List<NaucniRadDTO> sviNaucniRadovi = new ArrayList<>();
        List<NaucniRad> naucniRadovi = naucniRadRepository.findByIzdanjeMagazinaId(izdanjeMagazinaId);
        if (korisnik.isPresent()) {
            if (Constants.ULOGA_CITALAC.equals(korisnik.get().getUloga())) {
                for (NaucniRad naucniRad : naucniRadovi) {
                    Magazin m = magazinRepository.findById(naucniRad.getMagazinId()).get();
                    IzdanjeMagazina izdanjeMagazina = izdanjeMagazinaRepository.findById(izdanjeMagazinaId).get();
                    NaucniRadDTO naucniRadDTO = new NaucniRadDTO(m, izdanjeMagazina, naucniRad.getKoautori(), naucniRad.getKljucniPojmovi(), naucniRad.getNaucnaOblast(),
                            naucniRad.getCena(), naucniRad.getLink());
                    if (!m.getOpenAccess()) {
                        if (placenaClanarinaZaMagazin(korisnikId, m.getId())) {
                            naucniRadDTO.setPreuzmiRad(true);
                            naucniRadDTO.setKupiRad(false);
                        }
                        else {
                            if (kupljeno(korisnikId, izdanjeMagazinaId, Constants.TIP_PROIZVODA_IZDANJE_MAGAZINA)) {
                                naucniRadDTO.setPreuzmiRad(true);
                                naucniRadDTO.setKupiRad(false);
                            }
                            else {
                                if (kupljeno(korisnikId, naucniRad.getId(), Constants.TIP_PROIZVODA_NAUCNI_RAD)) {
                                    naucniRadDTO.setPreuzmiRad(true);
                                    naucniRadDTO.setKupiRad(false);
                                } else {
                                    naucniRadDTO.setPreuzmiRad(false);
                                    naucniRadDTO.setKupiRad(true);
                                }
                            }
                        }
                    }
                    else {
                        naucniRadDTO.setPreuzmiRad(true);
                        naucniRadDTO.setKupiRad(false);
                    }
                    sviNaucniRadovi.add(naucniRadDTO);
                }
            }
        }

        return sviNaucniRadovi;

    }


    private boolean kupljeno(Long korisnikId, Long proizvodId, String tipProizvoda) {
        Kupovina kupovina = kupovinaRepository.findByKorisnikIdAndProizvodIdAndTipProizvoda(korisnikId, proizvodId, tipProizvoda);
        if (kupovina!=null) {
            return true;
        }
        else {
            return false;
        }
    }

    public Kupovina kupovina(Long korisnikId, Long proizvodId, String tipProizvoda) {
        Kupovina kupovina = new Kupovina(korisnikId, proizvodId, tipProizvoda);
        kupovina = kupovinaRepository.save(kupovina);
        return kupovina;
    }


}
