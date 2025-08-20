package ve.ccs.infosoft.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ve.ccs.infosoft.model.Pregunta;
import ve.ccs.infosoft.repository.PreguntaRepository;

@Service
	public class PreguntaService {

		@Autowired
		PreguntaRepository preguntaRepository;

		public Pregunta save(Pregunta pregunta) {
			return preguntaRepository.save(pregunta);
		}

		public List<Pregunta> findAll() {
			return preguntaRepository.findAll();
		}
		
		
		public Page<Pregunta> findAll(Pageable pageable) {
			return preguntaRepository.findAll(pageable);
		}

		public Optional<Pregunta> findById(Integer id) {
			return preguntaRepository.findById(id);
		}

		public void deleteById(Integer id) {
			preguntaRepository.deleteById(id);
		}

		public boolean existsById(Integer id) {
			return preguntaRepository.existsById(id);
		}

		public List<Pregunta> saveAll(List<Pregunta> preguntas) {
			return preguntaRepository.saveAll(preguntas);
		}

	}
	

