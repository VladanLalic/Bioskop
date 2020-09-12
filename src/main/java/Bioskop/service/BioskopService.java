package Bioskop.service;


import Bioskop.repo.BioskopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BioskopService {
    @Autowired
    private BioskopRepo bioskopRepo;
}
