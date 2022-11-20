package com.example.pro_a.DBinterface;

import com.example.pro_a.Entity.Cartoon_img;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CartoonImgRepository extends JpaRepository<Cartoon_img,Long> {

    @Query(nativeQuery = true , value = "select * from cartoon_img where img_1 = :localStorePath ")
    Cartoon_img findByImg1(String localStorePath);


    @Modifying(clearAutomatically = true)
    @Query(value = "update Cartoon_img i set i.img1 = :img1 ,i.img2 = :img2 ,i.img3 = :img3 , i.img4 = :img4 where i.cartoon_id = :id ")
    void update(@Param("id") Long cartoon_id,@Param("img1") String img1,@Param("img2") String img2,@Param("img3") String img3,@Param("img4") String img4);

    @Query(nativeQuery = true , value = "select * from cartoon_img order by cartoon_id asc limit 1")
    Cartoon_img lastIndex();
}
