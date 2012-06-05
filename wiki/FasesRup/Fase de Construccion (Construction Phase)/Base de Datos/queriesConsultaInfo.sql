SELECT *
FROM estado_resultados AS E
WHERE E.id_dep = '2' AND E.id_banco = '1' AND aÃ±o IN ( SELECT MAX(aÃ±o) -1
                                                        FROM estado_resultados AS E
                                                        ORDER BY E.id_edo
                                                      );


SELECT *
FROM estado_resultados AS E
WHERE E.id_dep = '2' AND E.id_banco = '1' AND mes IN (  SELECT MAX(mes) -1
                                                        FROM estado_resultados AS E
                                                    
                                                        )AND aÃ±o IN ( SELECT MAX(aÃ±o)
                                                                        FROM estado_resultados AS E
                                                                                                                    
                                                                     )
ORDER BY E.id_edo;
