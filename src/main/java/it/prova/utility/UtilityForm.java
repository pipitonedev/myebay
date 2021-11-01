package it.prova.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import it.prova.model.Acquisto;
import it.prova.model.Annuncio;
import it.prova.model.Utente;

public class UtilityForm {

	public static Acquisto createAcquistoFromParams(String descrizioneInputParam, String dataAcquistoInputParam,
			String prezzoInputParam, String utenteIdStringParam) {

		Acquisto result = new Acquisto(descrizioneInputParam);
		if (NumberUtils.isCreatable(prezzoInputParam)) {
			result.setPrezzo(Integer.parseInt(prezzoInputParam));
		}
		result.setDataAcquisto(parseDateArrivoFromString(dataAcquistoInputParam));
		if (NumberUtils.isCreatable(utenteIdStringParam)) {
			result.setUtenteAcquirente(new Utente(Long.parseLong(utenteIdStringParam)));
		}
		return result;
	}

	public static boolean validateAcquistoBean(Acquisto acquistoToBeValidated) {
		if (StringUtils.isBlank(acquistoToBeValidated.getDescrizione()) || acquistoToBeValidated.getPrezzo() == null
				|| acquistoToBeValidated.getPrezzo() < 1 || acquistoToBeValidated.getUtenteAcquirente() == null
				|| acquistoToBeValidated.getUtenteAcquirente().getId() == null
				|| acquistoToBeValidated.getUtenteAcquirente().getId() < 1) {
			return false;
		}
		return true;
	}

	public static Annuncio createAnnuncioFromParams(String testoAnnuncioInputParam, String prezzoInputParam) {
		Date dataCreatedParam = new Date();

		Annuncio result = new Annuncio(testoAnnuncioInputParam, dataCreatedParam);

		if (NumberUtils.isCreatable(prezzoInputParam)) {
			result.setPrezzo(Integer.parseInt(prezzoInputParam));
		}

		result.setAperto(true);

		return result;

	}

	public static boolean validateAnnuncioBean(Annuncio annuncioToBeValidated) {
		// prima controlliamo che non siano vuoti i parametri
		if (StringUtils.isBlank(annuncioToBeValidated.getTestoAnnuncio()) || annuncioToBeValidated.getPrezzo() == null
				|| annuncioToBeValidated.getPrezzo() < 1 || annuncioToBeValidated.getDataAnnuncio() == null) {
			return false;
		}
		return true;
	}

	public static Date parseDateArrivoFromString(String dataAcquistoStringParam) {
		if (StringUtils.isBlank(dataAcquistoStringParam))
			return null;

		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(dataAcquistoStringParam);
		} catch (ParseException e) {
			return null;
		}
	}

}
