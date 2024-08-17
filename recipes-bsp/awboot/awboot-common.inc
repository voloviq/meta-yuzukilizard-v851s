SECTION = "bootloaders"
LICENSE = "BSD-3-Clause & LGPL-2.1-only & GPL-2.0-only"
LIC_FILES_CHKSUM = "file://README.md;md5=34767e046700ccf2a052969fccda1141"

DEPENDS += " coreutils-native gcc-arm-none-eabi-native"

SRC_URI = "\
    git://github.com/szemzoa/awboot.git;protocol=https;branch=next \
"
SRCREV = "ec1cd701d6634f144bff4bf9dd9a21b826803761"

S = "${WORKDIR}/git"

