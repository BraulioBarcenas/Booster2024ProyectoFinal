package com.booster.AssesmentFinal.grpc;

import com.booster.AssesmentFinal.data.Libro;
import com.booster.AssesmentFinal.repository.LibroRepository;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;


@GrpcService
public class BookServiceGrpcImpl extends BookServiceGrpc.BookServiceImplBase{

    @Autowired
    private LibroRepository libroRepository;

    @Override
    public void getBook(BookRequest request, StreamObserver<BookResponse> responseObserver){
        Libro libro = libroRepository.findById(request.getId()).orElse(null);
        if (libro != null){
            BookResponse response = BookResponse.newBuilder()
                    .setId(libro.getId())
                    .setName(libro.getNombre())
                    .build();
            responseObserver.onNext(response);
        }
        responseObserver.onCompleted();
    }

    @Override
    public void createBook(CreateBookRequest request,StreamObserver<BookResponse> responseObserver){
        Libro libro = new Libro();
        libro.setNombre(request.getName());
        libro = libroRepository.save(libro);
        BookResponse response = BookResponse.newBuilder()
                .setId(libro.getId())
                .setName(libro.getNombre())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void updateBook(UpdateBookRequest request, StreamObserver<BookResponse> responseObserver){
        Libro libro = libroRepository.findById(request.getId()).orElse(null);
        if (libro != null) {
            libro.setNombre(request.getName());
            libro = libroRepository.save(libro);
            BookResponse response = BookResponse.newBuilder()
                    .setId(libro.getId())
                    .setName(libro.getNombre())
                    .build();
            responseObserver.onNext(response);
        }
        responseObserver.onCompleted();
    }

    @Override
    public void deleteBook(DeleteBookRequest request, StreamObserver<DeleteBookResponse> responseObserver){
        libroRepository.deleteById(request.getId());
        DeleteBookResponse response = DeleteBookResponse.newBuilder()
                .setSuccess(true)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
