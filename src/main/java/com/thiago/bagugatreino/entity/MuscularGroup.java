package com.thiago.bagugatreino.entity;

public enum MuscularGroup {
    PEITO,
    COSTAS,
    PERNAS,
    OMBROS,
    BICEPS,
    TRICEPS,
    ABDOMINAIS,
    ANTEBRACOS,
    PANTURRILHAS,
    GLUTEOS;

    /**
     * Retorna uma representação amigável do grupo muscular.
     */
    @Override
    public String toString() {
        String nome = name().toLowerCase().replace('_', ' ');
        return nome.substring(0, 1).toUpperCase() + nome.substring(1);
    }
}

