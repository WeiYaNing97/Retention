import request from '@/utils/request'

// 查询活动测试列表
export function listTestActivity(query) {
  return request({
    url: '/test/testActivity/list',
    method: 'get',
    params: query
  })
}

// 查询活动测试详细
export function getTestActivity(id) {
  return request({
    url: '/test/testActivity/' + id,
    method: 'get'
  })
}

// 新增活动测试
export function addTestActivity(data) {
  return request({
    url: '/test/testActivity',
    method: 'post',
    data: data
  })
}

// 修改活动测试
export function updateTestActivity(data) {
  return request({
    url: '/test/testActivity',
    method: 'put',
    data: data
  })
}

// 删除活动测试
export function delTestActivity(id) {
  return request({
    url: '/test/testActivity/' + id,
    method: 'delete'
  })
}
