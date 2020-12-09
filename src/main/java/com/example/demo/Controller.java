package com.example.demo;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;

@RestController()
public class Controller {

	private static final String DEFAULT_LOCALE_DATE_TIME_FORMAT = "dd-MM-yyyy";

	@GetMapping("/brojAktivnihKorisnika")
	private ResponseEntity<?> response1() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DEFAULT_LOCALE_DATE_TIME_FORMAT);
		MongoClient mongoClient = MongoClients.create(
				"mongodb+srv://josip:N1Rj4K6zyZjszvMH@cluster1.xtxqi.mongodb.net/test?authSource=admin&replicaSet=atlas-qdn4i9-shard-0&readPreference=primary&appname=MongoDB%20Compass&ssl=true");
		MongoDatabase tMongoDatabase = mongoClient.getDatabase("Database1");
		MongoCollection<Document> tCollection = tMongoDatabase.getCollection("statistika2020_josip_proba_1");
		LocalDate jucer = LocalDate.parse("01-01-2020", formatter);
		LocalDate danas = LocalDate.parse("02-01-2020", formatter);
		AggregateIterable<Document> aggregate = tCollection.aggregate(Arrays.asList(
				Aggregates.match(Filters.gte("datum", jucer)), Aggregates.match(Filters.lt("datum", danas)),
				Aggregates.match(Filters.or(
						Filters.and(Filters.elemMatch("orgJedinice", Filters.exists("infPosrednikZaprimanje")),
								Filters.eq("orgJedinice.infPosrednikZaprimanje.idSustava", 1)),
						Filters.and(Filters.elemMatch("orgJedinice", Filters.exists("infPosrednikSlanje")),
								Filters.eq("orgJedinice.infPosrednikSlanje.idSustava", 1))))));
		List<Document> lista = new ArrayList<>();
		MongoCursor<Document> iterator = aggregate.iterator();
		while (iterator.hasNext()) {
			lista.add(iterator.next());
		}
		return new ResponseEntity<List<Document>>(lista, HttpStatus.ACCEPTED);

	}

	@GetMapping("/brojAktivnihPosiljateljaIPrimatelja")
	private ResponseEntity<?> response2() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DEFAULT_LOCALE_DATE_TIME_FORMAT);
		MongoClient mongoClient = MongoClients.create(

				"mongodb+srv://josip:N1Rj4K6zyZjszvMH@cluster1.xtxqi.mongodb.net/test?authSource=admin&replicaSet=atlas-qdn4i9-shard-0&readPreference=primary&appname=MongoDB%20Compass&ssl=true");
		MongoDatabase tMongoDatabase = mongoClient.getDatabase("Database1");
		MongoCollection<Document> tCollection = tMongoDatabase.getCollection("statistika2020_josip_proba_1");
		LocalDate jucer = LocalDate.parse("01-01-2020", formatter);
		LocalDate danas = LocalDate.parse("02-01-2020", formatter);
		AggregateIterable<Document> aggregate = tCollection.aggregate(Arrays.asList(
				Aggregates.match(Filters.gte("datum", jucer)), Aggregates.match(Filters.lt("datum", danas)),
				Aggregates.match(Filters.elemMatch("orgJedinice", Filters.exists("infPosrednikSlanje"))),
				Aggregates.match(Filters.elemMatch("orgJedinice", Filters.exists("infPosrednikZaprimanje")))));
		List<Document> lista = new ArrayList<>();
		MongoCursor<Document> iterator = aggregate.iterator();
		while (iterator.hasNext()) {
			lista.add(iterator.next());
		}
		return new ResponseEntity<List<Document>>(lista, HttpStatus.ACCEPTED);

	}

	@GetMapping("/brojAktivnihPosiljatelja")
	private ResponseEntity<?> response3() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DEFAULT_LOCALE_DATE_TIME_FORMAT);
		MongoClient mongoClient = MongoClients.create(

				"mongodb+srv://josip:N1Rj4K6zyZjszvMH@cluster1.xtxqi.mongodb.net/test?authSource=admin&replicaSet=atlas-qdn4i9-shard-0&readPreference=primary&appname=MongoDB%20Compass&ssl=true");
		MongoDatabase tMongoDatabase = mongoClient.getDatabase("Database1");
		MongoCollection<Document> tCollection = tMongoDatabase.getCollection("statistika2020_josip_proba_1");
		LocalDate jucer = LocalDate.parse("01-01-2020", formatter);
		LocalDate danas = LocalDate.parse("02-01-2020", formatter);
		AggregateIterable<Document> aggregate = tCollection.aggregate(Arrays.asList(
				Aggregates.match(Filters.gte("datum", jucer)), Aggregates.match(Filters.lt("datum", danas)),
				Aggregates.match(Filters.elemMatch("orgJedinice", Filters.exists("infPosrednikSlanje"))),
				// Aggregates.match(Filters.elemMatch("orgJedinice",
				// Filters.ex("infPosrednikZaprimanje"))),
				Aggregates.count("zbroj")));
		List<Document> lista = new ArrayList<>();
		MongoCursor<Document> iterator = aggregate.iterator();
		while (iterator.hasNext()) {
			lista.add(iterator.next());
		}
		return new ResponseEntity<List<Document>>(lista, HttpStatus.ACCEPTED);

	}

	@GetMapping()
	private ResponseEntity<?> response() {
		long idPs = 1;
		long idOrgJed = 1;
		long brojDok = 1;
		int minPos = 10;
		int max = 40;
		int maxOrgJed = 30;
		int maxDoc = 500;
		int infPosEnumLength = InformacijskiPosredniciEnum.values().length;
		int tipZaPLength = TipZaprimanjaPraviEnum.values().length;
		int tipDokLength = TipDokumentaEnum.values().length;
		int tipZapPret = TipZaprimanjaPretinac.values().length;
		Random random = new Random();
		List<PoslovniSubjekt> tPSubjList = new ArrayList<>();
		idPs = 1;
		idPs = 1;
		for (int p = 0; p < 360; p++) {
			idPs = 1;
			for (int i = 0; i < ThreadLocalRandom.current().nextInt(minPos, max + 1); i++) {
				PoslovniSubjekt ps = new PoslovniSubjekt();
				int sustav = ThreadLocalRandom.current().nextInt(1, 3);
				ps.setIdPs(idPs);
				ps.setNazivPs("ps" + idPs);
				ps.setDatum(LocalDateTime.of(2020, 1, 1, 1, 1).plusDays(p));
				List<OrganizacijskaJedinica> tOrgJednList = new ArrayList<>();
				for (int j = 0; j < ThreadLocalRandom.current().nextInt(0, maxOrgJed + 1); j++) {
					OrganizacijskaJedinica pOrgJednica = new OrganizacijskaJedinica();
					pOrgJednica.setIdOrgJedinice(idOrgJed);
					pOrgJednica.setNazivOrgJedinice("orgJed" + idOrgJed);
					TipZaprimanjaPretinac tipZaprimanjaPretinac = TipZaprimanjaPretinac.values()[random
							.nextInt(tipZapPret)];
					pOrgJednica.setTipZaprimanja(tipZaprimanjaPretinac.getiSifra());
					pOrgJednica.setTipZaprimanjaOpis(tipZaprimanjaPretinac.getiOpis());
					InformacijskiPosredniciEnum tSlanje = null;
					if (ThreadLocalRandom.current().nextBoolean()) {
						InformacijskiPosrednik tInfPosSlanje = new InformacijskiPosrednik();
						InformacijskiPosredniciEnum bySifra = null;
						if (sustav == 1) {
							bySifra = InformacijskiPosredniciEnum.values()[ThreadLocalRandom.current().nextInt(0, 9)];
						} else {
							bySifra = InformacijskiPosredniciEnum.values()[ThreadLocalRandom.current().nextInt(9,
									infPosEnumLength)];
						}
						tInfPosSlanje.setIdSustava(bySifra.getiSustav());
						tInfPosSlanje.setIdInfPosrednika(bySifra.getSifra());
						tInfPosSlanje.setNazivInfPosrednika(bySifra.getOznaka());
						List<Dokument> tPoslaniDok = new ArrayList<>();
						for (int k = 0; k < ThreadLocalRandom.current().nextInt(0, maxDoc + 1); k++) {
							Dokument tDok = new Dokument();
							TipZaprimanjaPraviEnum tZap = TipZaprimanjaPraviEnum.values()[random.nextInt(tipZaPLength)];
							TipDokumentaEnum tTipDok = TipDokumentaEnum.values()[random.nextInt(tipDokLength)];
							double minValue = 0;
							double maxvalues = 123123;
							if (!tTipDok.getVrstaDokumenta().equals(VrstaDokumentaEnum.INVOICE)) {
								minValue = -3000.00;
								maxvalues = 0;
							}
							tDok.setIdDokumenta(brojDok);
							tDok.setIznos(ThreadLocalRandom.current().nextDouble(minValue, maxvalues));
							tDok.setTipDokumenta(tTipDok.getSifra());
							tDok.setTipDokumentaOpis(tTipDok.getNaziv());
							tDok.setTipZaprimanja(tZap.getSifra());
							tDok.setTipZaprimanjaOpis(tZap.getOpis());
							tPoslaniDok.add(tDok);
							brojDok++;
						}
						tInfPosSlanje.setPoslaniDokumenti(tPoslaniDok);
						pOrgJednica.setInfPosrednikSlanje(tInfPosSlanje);
						tSlanje = bySifra;
					}
					InformacijskiPosrednik tInfPosSZapr = new InformacijskiPosrednik();
					InformacijskiPosredniciEnum bySifraZapr = null;
					boolean zaZap = ThreadLocalRandom.current().nextBoolean();
					if (tSlanje == null) {
						if (sustav == 1)
							bySifraZapr = InformacijskiPosredniciEnum.values()[ThreadLocalRandom.current().nextInt(0,
									9)];
						else
							bySifraZapr = InformacijskiPosredniciEnum.values()[ThreadLocalRandom.current().nextInt(9,
									tipZaPLength)];
					}
					if (tSlanje != null && tSlanje.getiSustav() == 1 && zaZap) {
						bySifraZapr = InformacijskiPosredniciEnum.values()[ThreadLocalRandom.current().nextInt(0, 9)];
					}
					if (tSlanje != null && tSlanje.getiSustav() == 2 && zaZap) {
						bySifraZapr = InformacijskiPosredniciEnum.values()[ThreadLocalRandom.current().nextInt(9,
								tipZaPLength)];
					}
					if (bySifraZapr != null) {
						tInfPosSZapr.setIdSustava(bySifraZapr.getiSustav());
						tInfPosSZapr.setIdInfPosrednika(bySifraZapr.getSifra());
						tInfPosSZapr.setNazivInfPosrednika(bySifraZapr.getOznaka());
						List<Dokument> tZapDok = new ArrayList<>();
						for (int k = 0; k < 10; k++) {
							Dokument tDok = new Dokument();
							TipZaprimanjaPraviEnum tZap = TipZaprimanjaPraviEnum.values()[random.nextInt(tipZaPLength)];
							TipDokumentaEnum tTipDok = TipDokumentaEnum.values()[random.nextInt(tipDokLength)];
							tDok.setIdDokumenta(brojDok);
							tDok.setIznos(ThreadLocalRandom.current().nextDouble(0, 123123 + 1));
							tDok.setTipDokumenta(tTipDok.getSifra());
							tDok.setTipDokumentaOpis(tTipDok.getNaziv());
							tDok.setTipZaprimanja(tZap.getSifra());
							tDok.setTipZaprimanjaOpis(tZap.getOpis());
							tZapDok.add(tDok);
							brojDok++;
						}
						tInfPosSZapr.setPrimljeniDokumenti(tZapDok);
						pOrgJednica.setInfPosrednikZaprimanje(tInfPosSZapr);
					}

					tOrgJednList.add(pOrgJednica);
					idOrgJed++;
				}
				ps.setOrgJedinice(tOrgJednList);
				tPSubjList.add(ps);
				idPs++;
			}
		}

		return new ResponseEntity<List<PoslovniSubjekt>>(tPSubjList, HttpStatus.ACCEPTED);
	}

}
