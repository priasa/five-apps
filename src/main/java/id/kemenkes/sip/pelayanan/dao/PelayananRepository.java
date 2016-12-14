package id.kemenkes.sip.pelayanan.dao;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.sort;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mongodb.DBObject;

import id.kemenkes.sip.common.entity.BulanCount;
import id.kemenkes.sip.common.entity.KabupatenCount;
import id.kemenkes.sip.common.entity.ProvinsiCount;
import id.kemenkes.sip.common.entity.PuskesmasCount;
import id.kemenkes.sip.pelayanan.entity.PelayananEntity;


@Repository
public class PelayananRepository {

	static final Logger LOGGER = LoggerFactory.getLogger(PelayananRepository.class);

	@Autowired
	private MongoTemplate mongoTemplate;

	public void save(PelayananEntity entity) {
		mongoTemplate.save(entity);
	}

	public PelayananEntity getById(String id) {
		return mongoTemplate.findById(id, PelayananEntity.class);
	}

	public Page<PelayananEntity> getByFilter(String kodePuskesmas, int tahun, int bulan, Pageable page) {
		Query query = new Query();
		query.addCriteria(Criteria.where("kodePuskesmas").regex(kodePuskesmas, "i"));
		if (tahun != 0) {
			query.addCriteria(Criteria.where("tahun").is(tahun));
		}

		if (bulan != 0) {
			query.addCriteria(Criteria.where("bulan").is(bulan));
		}
		query.with(page);

		List<PelayananEntity> content = mongoTemplate.find(query, PelayananEntity.class);

		long size = countByFilter(kodePuskesmas, tahun, bulan);
		PageImpl<PelayananEntity> result = new PageImpl<PelayananEntity>(content, page, size);

		return result;
	}

	public long countByFilter(String kodePuskesmas, int tahun, int bulan) {
		Query query = new Query();
		query.addCriteria(Criteria.where("kodePuskesmas").regex(kodePuskesmas, "i"));
		if (tahun != 0) {
			query.addCriteria(Criteria.where("tahun").is(tahun));
		}

		if (bulan != 0) {
			query.addCriteria(Criteria.where("bulan").is(bulan));
		}
		long counter = mongoTemplate.count(query, PelayananEntity.class);

		return counter;
	}

	public void deleteById(String id) {
		PelayananEntity pelayananEntity = this.getById(id);
		mongoTemplate.remove(pelayananEntity);
	}

	public int countFieldDistinctByQuery(String field, DBObject dbObject) {
		return mongoTemplate.getCollection("PELAYANAN").distinct(field, dbObject).size();
	}

	@SuppressWarnings("rawtypes")
	public List aggregationProvinsiByYear(Integer tahun) {
		Aggregation aggregation = newAggregation(match(Criteria.where("tahun").is(tahun)),
				group("provinsi").count().as("totalData"),
				project("totalData").and("provinsi").previousOperation(),
				sort(Sort.Direction.ASC, "provinsi"));

		AggregationResults groupResults = mongoTemplate.aggregate(aggregation, PelayananEntity.class, ProvinsiCount.class);

		List provinsiReport = groupResults.getMappedResults();

		return provinsiReport;
	}
	
	@SuppressWarnings("rawtypes")
	public List aggregationBulanByYear(Integer tahun) {
		Aggregation aggregation = newAggregation(match(Criteria.where("tahun").is(tahun)),
				group("bulan").count().as("totalData"),
				project("totalData").and("bulan").previousOperation(),
				sort(Sort.Direction.ASC, "bulan"));

		AggregationResults groupResults = mongoTemplate.aggregate(aggregation, PelayananEntity.class, BulanCount.class);

		List bulanReport = groupResults.getMappedResults();

		return bulanReport;
	}
	
	@SuppressWarnings("rawtypes")
	public List aggregationKabupatenByYear(Integer tahun, Integer provinsi) {
		Aggregation aggregation = newAggregation(match(Criteria.where("tahun").is(tahun).andOperator(Criteria.where("provinsi").is(provinsi))),
				group("provinsi","kotaKabupaten").count().as("totalData"),
				sort(Sort.Direction.ASC, "provinsi"));

		AggregationResults groupResults = mongoTemplate.aggregate(aggregation, PelayananEntity.class, KabupatenCount.class);

		List kabupatenReport = groupResults.getMappedResults();

		return kabupatenReport;
	}
	
	@SuppressWarnings("rawtypes")
	public List aggregationPuskesmasByYear(Integer tahun, Integer provinsi, Integer kotaKabupaten) {
		Aggregation aggregation = newAggregation(match(Criteria.where("tahun").is(tahun)
				.andOperator(Criteria.where("provinsi").is(provinsi).andOperator(Criteria.where("kotaKabupaten").is(kotaKabupaten)))),
				group("provinsi", "kotaKabupaten", "kodePuskesmas").count().as("totalData"),
				sort(Sort.Direction.ASC, "provinsi"));

		AggregationResults groupResults = mongoTemplate.aggregate(aggregation, PelayananEntity.class, PuskesmasCount.class);

		List puskesmasReport = groupResults.getMappedResults();

		return puskesmasReport;
	}
}
