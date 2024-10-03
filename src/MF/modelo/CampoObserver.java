package MF.modelo;

@FunctionalInterface
public interface CampoObserver {
	public void eventoOcorreu(Campo campo, CampoEvento evento);
}
