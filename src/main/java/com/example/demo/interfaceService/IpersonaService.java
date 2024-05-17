package com.example.demo.interfaceService;
import java.util.*;
import com.example.demo.modelo.*;
public interface IpersonaService {
	public List<Persona>Listar();
	public Optional<Persona>listarId(int id);
	public int save(Persona p);
	public void delete(int id );
	
}
