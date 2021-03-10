package com.etnetera.hr.data;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "version")
public class FrameworkVersion {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String version;

    private LocalDate deprecationDate;

    public enum HypeLevel {
        NOBODY_USES_IT,
        SOMEBODY_USES_IT,
        EVERYBODY_USES_IT
    }

    private HypeLevel hypeLevel = HypeLevel.NOBODY_USES_IT;

    @ManyToOne
    private JavaScriptFramework framework;

    public FrameworkVersion() {
    }

    public JavaScriptFramework getFramework() {
        return framework;
    }

    public void setFramework(JavaScriptFramework framework) {
        this.framework = framework;
    }

    public FrameworkVersion(String version, LocalDate deprecationDate, HypeLevel hypeLevel) {
        this.version = version;
        this.deprecationDate = deprecationDate;
        this.hypeLevel = hypeLevel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public LocalDate getDeprecationDate() {
        return deprecationDate;
    }

    public void setDeprecationDate(LocalDate deprecationDate) {
        this.deprecationDate = deprecationDate;
    }

    public HypeLevel getHypeLevel() {
        return hypeLevel;
    }

    public void setHypeLevel(HypeLevel hypeLevel) {
        this.hypeLevel = hypeLevel;
    }
}

