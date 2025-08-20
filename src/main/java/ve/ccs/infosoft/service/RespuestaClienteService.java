package ve.ccs.infosoft.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import ve.ccs.infosoft.model.Cliente;
import ve.ccs.infosoft.model.Instrumento;
import ve.ccs.infosoft.model.Pregunta;
import ve.ccs.infosoft.model.RespuestaCliente;
import ve.ccs.infosoft.repository.ClienteRepository;
import ve.ccs.infosoft.repository.InstrumentoRepository;
import ve.ccs.infosoft.repository.PreguntaRepository;
import ve.ccs.infosoft.repository.RespuestaClienteRepository;

@Service
@Transactional
public class RespuestaClienteService {

	@Autowired
	RespuestaClienteRepository respuestaRepository;
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	PreguntaRepository preguntaRepository;
	@Autowired
	InstrumentoRepository instrumentoRepository;

	public RespuestaCliente guardarRespuesta(Integer clienteId, Integer preguntaId, Integer instrumentoId,
			String respuesta) {
		Cliente cliente = clienteRepository.findById(clienteId)
				.orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

		Pregunta pregunta = preguntaRepository.findById(preguntaId)
				.orElseThrow(() -> new RuntimeException("Pregunta no encontrada"));

		Instrumento instrumento = instrumentoRepository.findById(instrumentoId)
				.orElseThrow(() -> new RuntimeException("Instrumento no encontrado"));

		RespuestaCliente nuevaRespuesta = new RespuestaCliente();
		nuevaRespuesta.setCliente(cliente);
		nuevaRespuesta.setPregunta(pregunta);
		nuevaRespuesta.setInstrumento(instrumento);
		nuevaRespuesta.setRespuesta(respuesta);
		nuevaRespuesta.setFechaRegistro(LocalDateTime.now());

		return respuestaRepository.save(nuevaRespuesta);
	}

	public List<RespuestaCliente> obtenerTodasLasRespuestas() {
		return respuestaRepository.findAll();
	}

	public Optional<RespuestaCliente> obtenerRespuestaPorId(Integer id) {
		return respuestaRepository.findById(id);
	}

	public RespuestaCliente actualizarRespuesta(Integer id, String nuevaRespuesta) {
		RespuestaCliente respuesta = respuestaRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Respuesta no encontrada"));

		respuesta.setRespuesta(nuevaRespuesta);
		return respuestaRepository.save(respuesta);
	}

	public void eliminarRespuesta(Integer id) {
		respuestaRepository.deleteById(id);
	}
	
	
	public List<RespuestaCliente> guardarTodos(List<RespuestaCliente> respuestaCliente) {
		return respuestaRepository.saveAll(respuestaCliente);
	}

	
	
	  // Método adicional: Verificar si un cliente ya respondió una pregunta en un instrumento
//    public boolean existeRespuesta(Long clienteId, Long preguntaId, Long instrumentoId) {
//        return respuestaRepository.existsByClienteIdAndPreguntaIdAndInstrumentoId(
//                clienteId, preguntaId, instrumentoId);
//    }

}
