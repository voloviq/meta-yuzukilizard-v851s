DESCRIPTION = "Linux Kernel Tar version"
SECTION = "kernel"
LICENSE = "GPLv2"

COMPATIBLE_MACHINE = "sun8i"

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"
KERNEL_FEATURES:remove = "cfg/fs/vfat.scc"

SRC_URI = "\
    https://cdn.kernel.org/pub/linux/kernel/v6.x/linux-6.6.40.tar.xz \
    file://v851s-lizard-linux-v6.6-rc1.patch \
    file://defconfig \
    file://enable-linuxfb.cfg \
    "
SRC_URI[sha256sum] = "5c3a3c03c055b8d601a6d7f80d1465ada6b83a12299f6ace2027b47f0baff538"

LINUX_VERSION ?= "${PV}"
LINUX_VERSION_EXTENSION:append = "-custom"

S = "${WORKDIR}/linux-${PV}"
