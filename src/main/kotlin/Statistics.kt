fun calcDispersion(shots: List<Shot>): Map<ShotResult, Double> {
    return ShotResult.entries.associateWith { shot -> if (shots.isEmpty()) 0.00 else (shots.count { it.result == shot }.toDouble() / shots.size * 100.00).round(2) }
}

fun Double.round(decimalPrecision: Int): Double {
    return String.format("%.${decimalPrecision}f", this).toDouble()
}