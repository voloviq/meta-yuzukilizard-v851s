LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://README.md;md5=6290e7c237e3c515b5d78b0a20b8f5ba"
SUMMARY = "AWboot tools"
HOMEPAGE = "https://github.com/szemzoa/awboot"

require awboot-common.inc

PROVIDES = "${MLPREFIX}awboot-mksunxi"
PROVIDES:class-native = "awboot-mksunxi-native"

PACKAGES += "${PN}-mksunxi"

EXTRA_OEMAKE:class-target = 'CROSS_COMPILE="${TARGET_PREFIX}" CC="${CC} ${CFLAGS} ${LDFLAGS}" HOSTCC="${BUILD_CC} ${BUILD_CFLAGS} ${BUILD_LDFLAGS}" STRIP=true V=1'
EXTRA_OEMAKE:class-native = 'CC="${BUILD_CC} ${BUILD_CFLAGS} ${BUILD_LDFLAGS}" HOSTCC="${BUILD_CC} ${BUILD_CFLAGS} ${BUILD_LDFLAGS}" STRIP=true V=1'
EXTRA_OEMAKE:class-nativesdk = 'CROSS_COMPILE="${HOST_PREFIX}" CC="${CC} ${CFLAGS} ${LDFLAGS}" HOSTCC="${BUILD_CC} ${BUILD_CFLAGS} ${BUILD_LDFLAGS}" STRIP=true V=1'

CFLAGS:append = " --specs=nosys.specs"
LDFLAGS:append = " --specs=nosys.specs"

do_compile(){
    oe_runmake tools -C ${S} O=${B}
}

do_install () {
	install -d ${D}${bindir}

	# mksunxi
	install -m 0755 tools/mksunxi ${D}${bindir}/awboot-mksunxi
	ln -sf awboot-mksunxi ${D}${bindir}/mksunxi

}

ALLOW_EMPTY_${PN} = "1"
#FILES:${PN} = ""
FILES:${PN}-mksunxi = "${bindir}/awboot-mksunxi ${bindir}/mksunxi"

BBCLASSEXTEND = "native nativesdk"
