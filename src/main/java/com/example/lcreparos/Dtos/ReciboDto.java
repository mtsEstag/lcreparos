package com.example.lcreparos.Dtos;

import com.example.lcreparos.models.Pagamento;
import com.example.lcreparos.models.Venda;

import lombok.Data;

@Data
public class ReciboDto {
    
    private Long idRecibo;

    private Venda venda;

    private Pagamento pagamento;
}
