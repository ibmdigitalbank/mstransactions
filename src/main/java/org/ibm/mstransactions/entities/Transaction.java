package org.ibm.mstransactions.entities;

        import io.swagger.annotations.ApiModelProperty;
        import lombok.AllArgsConstructor;
        import lombok.Data;
        import lombok.NoArgsConstructor;
        import lombok.ToString;

        import javax.persistence.*;
        import java.io.Serializable;
        import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The Id of the transaction")
    protected Long id;
    @ApiModelProperty(notes = "The Id of the transaction")
    protected Double source;
    @ApiModelProperty(notes = "The Id of the transaction")
    protected Double destination;
    @ApiModelProperty(notes = "The Id of the transaction")
    protected Date date;
    @ApiModelProperty(notes = "The Id of the transaction")
    protected Double montant;
    @ApiModelProperty(notes = "The Id of the transaction")
    protected String motif;
}
