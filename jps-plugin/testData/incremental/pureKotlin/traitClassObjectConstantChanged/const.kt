package test

interface Trait {
    companion object {
        // Old and new constant values are different, but their hashes are the same
        const val CONST = "BF"
    }
}
