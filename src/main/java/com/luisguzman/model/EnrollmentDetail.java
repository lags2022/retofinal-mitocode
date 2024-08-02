package com.luisguzman.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class EnrollmentDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idEnrollmentDetail;

    @ManyToOne
    @JoinColumn(name = "id_enrollment", nullable = false, foreignKey = @ForeignKey(name="FK_DETAIL_ENROLLMENT"))
    private Enrollment enrollment;

    @ManyToOne
    @JoinColumn(name = "id_class", nullable = false, foreignKey = @ForeignKey(name="FK_DETAIL_COURSE"))
    private Course course;

    @Column(nullable = false, length = 30)
    private String classroom;
}
