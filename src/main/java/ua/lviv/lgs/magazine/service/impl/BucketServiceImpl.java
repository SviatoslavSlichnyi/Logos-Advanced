package ua.lviv.lgs.magazine.service.impl;

import ua.lviv.lgs.magazine.domain.Bucket;
import ua.lviv.lgs.magazine.repository.BucketRepository;
import ua.lviv.lgs.magazine.repository.impl.BucketRepositoryImpl;
import ua.lviv.lgs.magazine.service.BucketService;

import java.util.List;

public class BucketServiceImpl implements BucketService {

    private BucketRepository bucketRepository;

    public BucketServiceImpl(BucketRepository bucketRepository) {
        this.bucketRepository = BucketRepositoryImpl.getInstance();
    }

    @Override
    public Bucket save(Bucket bucket) {
        return bucketRepository.save(bucket);
    }

    @Override
    public Bucket findById(Integer id) {
        return bucketRepository.findById(id);
    }

    @Override
    public Bucket update(Bucket bucket) {
        return bucketRepository.update(bucket);
    }

    @Override
    public Bucket deleteById(Integer id) {
        return bucketRepository.deleteById(id);
    }

    @Override
    public List<Bucket> findAll() {
        return bucketRepository.findAll();
    }
}
