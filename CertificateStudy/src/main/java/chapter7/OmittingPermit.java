package chapter7;

public sealed class OmittingPermit {

    non-sealed class NestedBadPractice extends OmittingPermit {
    }
}

final class SameFileBadPractice extends OmittingPermit {
}
