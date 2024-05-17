package com.example.demo.service;
import java.util.*;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.interfaceService.*;
import com.example.demo.interfaces.IPersona;
import com.example.demo.modelo.Persona;
@Service
public class PersonaService implements IpersonaService  {
	
    @Autowired
	private IPersona data;
    
	@Override
	public List<Persona> Listar() {
		// TODO Auto-generated method stub
		return (List<Persona>)data.findAll();
	}

	@Override
	public Optional<Persona> listarId(int id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public int save(Persona p) {
		int res=0;
		System.out.print(p);
		Persona persona=data.save(p);
		if	(!persona.equals(null)) {
		     res=1;	
		}
		return res;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}


}
