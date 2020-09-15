package app.models;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false)
    @NotBlank(message = "Tên thành phố không được để trống")
    private String name;


    @Column(name = "imageUrl", nullable = false)
    @URL(message = "Đường dẫn ảnh phải đúng định dạng URL")
    @NotBlank(message = "Đường dẫn ảnh không được để trống")
    private String imageUrl;

    @ManyToOne()
    @JoinColumn(name = "country",referencedColumnName = "id",nullable = false)
    private Country country;

    @Column(name = "area", nullable = false)
    @Range(min = 10L, max = 1000000L,message = "Giá trị tối thiểu là {min} và tối đa là {max}")
    private long area;

    @Column(name = "population", nullable = false)
    @Range(min = 1L, max = 100000000L,message = "Giá trị tối thiểu là {min} và tối đa là {max}")
    private long population;

    @Range(min = 1L, max = 1000000L,message = "Giá trị tối thiểu là {min} và tối đa là {max}")
    @Column(name = "gdp", nullable = false)
    private long gdp;

    @Length(min = 500,message = "Mô tả tối thiểu 500 ký tự")
    @Column(name = "description", nullable = false)
    @Lob
    private String description;

    public City() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public long getArea() {
        return area;
    }

    public void setArea(long area) {
        this.area = area;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public long getGdp() {
        return gdp;
    }

    public void setGdp(long gdp) {
        this.gdp = gdp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShortenDescription() {
        String shortenDes = "";
        if (description.length() <= 200) {
            shortenDes = description;
        } else {
            shortenDes = description.substring(0, 197) + "...";
        }
        return shortenDes;
    }
}
